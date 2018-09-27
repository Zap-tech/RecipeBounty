(ns rbounty.server.core
  (:require
   [cljs.nodejs :as node]
   [mount.core :as mount]
   [taoensso.timbre :as log]

   ;; District Components
   [district.server.web3]
   [district.server.smart-contracts :as contracts]
   [district.server.logging]))


;; Set by figwheel build
(goog-define DEV false)


(when-not DEV (node/enable-util-print!))


(def main-config
  {:web3 {:port 8545}
   :logging {:level :warn}
   :smart-contracts {:contracts-var #'rbounty.shared.smart-contracts/smart-contracts
                     :print-gas-usage? true
                     :auto-mining? false}})


(defn ^:export init [config]
  (log/debug "Initializing Server...")
  (mount/start (mount/with-args config)))


(defn -main [& args]
  (mount/start (mount/with-args main-config)))


(set! *main-cli-fn* -main)
