(ns rbounty.server.core
  (:require
   [cljs.nodejs :as node]
   [mount.core :as mount]
   
   ;; District Components
   [district.server.web3]
   [district.server.smart-contracts :as contracts]

   [rbounty.shared.smart-contracts]))

;; Set by figwheel build
(goog-define DEV false)


(when-not DEV (node/enable-util-print!))


(def main-config
  {:web3 {:port 8545}
   :smart-contracts {:contracts-var #'rbounty.shared.smart-contracts/smart-contracts
                     :print-gas-usage? true
                     :auto-mining? false}})


(defn ^:export init [config]
  (println "Initializing Server...")
  (mount/start (mount/with-args config)))


(defn -main [& args]
  (mount/start (mount/with-args main-config)))


(set! *main-cli-fn* -main)
