(ns cljs.user
  "Clojurescript Entrypoint for Node Server Repl."
  (:require-macros [rbounty.server.utils :refer [on-next-tick]])
  (:require
   [mount.core :as mount]

   ;; Mount State Components
   [district.server.web3]
   [district.server.smart-contracts]

   [rbounty.test-runner]
   [rbounty.server.deployer :as deployer]))


(def help-msg "
CLJS-Server Repl Commands:

  (start)          ;; Start Mount Components.
  (stop)           ;; Stop Mount Components.
  (restart)        ;; Restart Mount Components [useful].

  (run-tests)      ;; Run the Server Test Runner [useful].

  (deploy!)        ;; Deploy Smart Contracts Asynchronously.
  (deploy-sync!)   ;; Deploy Smart Contracts Synchronously.

  (help)           ;; Display this help message.

Notes:

  - Mount Components should already be started on initialization.
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


(defn run-tests
  "Run server tests in the development server."
  []
  (rbounty.test-runner/run))


(defn deploy!
  "Perform a smart contract deployment asynchronously."
  []
  (on-next-tick
   (deployer/deploy!)))


(defn deploy-sync!
  "Perform a smart contract deployment synchronously."
  []
  (deployer/deploy!))


(defn help
  "Print Help Message."
  []
  (println help-msg))


(defonce init-msg (help))
