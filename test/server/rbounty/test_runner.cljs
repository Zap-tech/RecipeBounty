(ns rbounty.test-runner
  "Test runner for the server. This can be run with `make test`."
  (:require 
    [cljs-test-display.core]
    [figwheel.main.testing :refer-macros [run-tests-async]]

    ;;
    ;; Test Namespaces
    ;;
    [rbounty.core-test]))


(def test-timeout (* 15 60 1000)) ;; 15 minutes


(defn run []
  (run-tests-async test-timeout))


(defn -main [& args]
  (run))
