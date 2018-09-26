(ns rbounty.server.deployer
  "Contains functions for performing a smart contract deployment on the
  ethereum blockchain.

  Notes:

  - Contract Deployments will update
  rbounty.shared.smart-contracts/smart-contracts. Be cautious with
  commits."
  (:require
   [taoensso.timbre :as log]))
   


(defn deploy! []
  (log/warn "Performing Deployment!")

  ;; ...

  (log/warn "Finished Deployment!"))
