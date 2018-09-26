(ns cljs.user
  "Clojurescript Entrypoint for Browser UI Repl."
  (:require
   [mount.core :as mount]

   ;; Mount State Components
   [district.ui.reagent-render]))


(def help-msg "
CLJS-UI Repl Commands:

  (start)          ;; Start Mount Components.
  (stop)           ;; Stop Mount Components.
  (restart)        ;; Restart Mount Components [useful].

  (open-tests)     ;; Opens a tab containing browser tests [useful].

  (help)           ;; Display this help message.
")


(defn start
  "Reloaded workflow, start state components."
  []  
  (mount/start))


(defn stop
  "Reloaded workflow, stop the state components."
  []
  (mount/stop))


(defn restart
  "Reloaded workflow, restart the state components."
  []
  (stop)
  (start))


(defn open-tests
  "Opens the browser test runner in a separate tab."
  []
  (let [host (aget js/window "location" "host")]
    (.open js/window (str "http://" host "/test-runner.html") "_blank")))


(defn help
  "Print Help Message."
  []
  (println help-msg))


(defonce init-msg (help))
