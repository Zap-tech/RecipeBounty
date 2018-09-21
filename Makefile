.PHONY: dev dev-ui dev-server
.PHONY: build-server build-ui build
.PHONY: test clean help


help:
	@echo "Commands:"
	@echo "  dev          :: Main Development Repl [Recommended]"
	@echo "  dev-ui       :: Start Figwheel Development for UI only"
	@echo "  dev-server   :: Start Figwheel Development for Server only"
	@echo ""
	@echo "  build        :: Make Production Build for Server and UI"
	@echo "  build-ui     :: Make Production Build for UI only"
	@echo "  build-server :: Make Production Build for Server only"
	@echo ""
	@echo "  clean        :: Clean out previous build artifacts for all builds"
	@echo ""
	@echo "  test         :: Run Server Test Runner"
	@echo ""
	@echo "  help         :: Display this help message"


dev:
	clj -A:dev -R:deps-ui


dev-ui:
	clj -A:fig-dev-ui -R:deps-ui


dev-server:
	clj -A:fig-dev-server


build-server:
	clj -A:build-prod-server


build-ui:
	clj -A:build-prod-ui -R:deps-ui


build: build-server build-ui
	cp -R ./resources/* ./dist/
	sed -i "s/dev-ui-main.js/build-prod-ui-main.js/g" ./dist/public/index.html


clean:
	rm -rf target
	rm -rf dist


test:
	clj -A:test-server
