(ns rbounty.test-runner
  (:require 
    [cljs-test-display.core]
    [figwheel.main.testing :refer-macros [run-tests]]

    ;;
    ;; Test Namespaces
    ;;
    [rbounty.core-test]))


(run-tests (cljs-test-display.core/init! "app-testing"))
