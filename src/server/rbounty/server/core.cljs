(ns rbounty.server.core)


;; Set by figwheel
(goog-define DEV false)


(defn -main [& args]
  (println "Hello World! " args))


(set! *main-cli-fn* -main)
