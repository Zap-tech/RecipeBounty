.PHONY: dev dev-ui dev-server test-runner help

help:
	@echo "Commands:"
	@echo "  dev         :: Main Development Repl [Recommended]"
	@echo "  dev-ui      :: Start Figwheel Development for UI only"
	@echo "  dev-server  :: Start Figwheel Development for Server only"
	@echo ""
	@echo "  test        :: Run Server Test Runner"
	@echo ""
	@echo "  help        :: Display this help message"


dev:
	clj -A:dev


dev-ui:
	clj -A:fig-dev-ui


dev-server:
	clj -A:fig-dev-server


test:
	clj -A:test-server
