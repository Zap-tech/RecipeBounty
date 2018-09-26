(ns ^:figwheel-hooks rbounty.dev-server
  "Node Server Main Function Entry."
  (:require
   [rbounty.server.core :refer [init main-config]]))
  

(def dev-config
  (merge main-config
         {}))


(defn -main [& args]
  (init dev-config))


;; Just call our main function
(defonce start-up (-main))


(defn ^:after-load re-init
  "Figwheel Reload Hook"
  []
  (println "Running reload hook...")
  (-main))


