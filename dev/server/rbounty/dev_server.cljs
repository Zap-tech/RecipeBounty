(ns ^:figwheel-hooks rbounty.dev-server
  "Node Server Main Function Entry."
  (:require
   [clojure.pprint :refer [pprint]]
   [rbounty.server.core :refer [init main-config]]))
  

(def dev-config
  (-> main-config
      (assoc-in [:web3 :url] "localhost")
      (assoc-in [:smart-contracts :auto-mining?] false)
      (assoc-in [:logging :level] "debug")
      (assoc-in [:logging :console?] true)))


(defonce start-up
  (do 
    (println "Initializing CLJS-Server Development Environment! Type (help) for repl commands.")
    (println "Development Configuration")
    (pprint dev-config)
    (init dev-config)))


(defn ^:after-load re-init
  "Figwheel Reload Hook"
  []
  (println "Running reload hook...")
  (init dev-config))
