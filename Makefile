# Makefile for district development
#
# Requirements:
#
# - node (Javascript Desktop Virtual Machine)
# - yarn (NodeJS Package Manager)
# - clj (Clojure CLI Tool)

.PHONY: init
.PHONY: dev dev-ui dev-server
.PHONY: build-server build-ui build-dist build
.PHONY: webpack
.PHONY: test deps clean help


help:
	@echo "Commands:"
	@echo "  init           :: Run on first-time setup"
	@echo ""
	@echo "  dev            :: Main Development Repl [Recommended]"
	@echo "  dev-ui         :: Start Figwheel Development for UI only"
	@echo "  dev-server     :: Start Figwheel Development for Server only"
	@echo ""
	@echo "  build          :: Make Production Build for Server and UI"
	@echo "  build-ui       :: Make Production Build for UI only"
	@echo "  build-server   :: Make Production Build for Server only"
	@echo "  build-dist     :: Prepare ./dist folder for Production Build"
	@echo ""
	@echo "  webpack        :: Build Webpack Bundle for UI"
	@echo ""
	@echo "  deps           :: Install Dependencies"
	@echo "  clean          :: Clean out previous build artifacts for all builds"
	@echo ""
	@echo "  test           :: Run Server Test Runner"
	@echo ""
	@echo "  help           :: Display this help message"


init: clean deps webpack


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


build-dist:
	cp -R ./resources/* ./dist/
	sed -i "s/dev-ui-main.js/build-prod-ui-main.js/g" ./dist/public/index.html
	cp -R ./node_modules ./dist/


build: clean deps webpack build-server build-ui build-dist


webpack:
	yarn webpack --config ./src/webpack/ui.config.js


deps:
	yarn install


clean:
	rm -rf node_modules
	rm -rf target
	rm -rf dist


test:
	clj -A:test-server
