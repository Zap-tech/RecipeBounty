(ns rbounty.server.deployer
  "Contains functions for performing a smart contract deployment on the
  ethereum blockchain.

  Notes:

  - Contract Deployments will update
  rbounty.shared.smart-contracts/smart-contracts. Be cautious with
  commits."
  (:require
   [taoensso.timbre :as log]

   [district.server.smart-contracts :as contracts]

   [rbounty.server.contract.recipe-exchange-mediator :as mediator]))
   

(defn deploy-mediator! []
  (contracts/deploy-smart-contract!
   :recipe-exchange-mediator
   {:gas 30000000 :arguments []}))


(defn deploy! []
  (log/info "Performing Deployment!")

  (deploy-mediator!)

  (contracts/write-smart-contracts!)

  (log/info "Finished Deployment!"))
