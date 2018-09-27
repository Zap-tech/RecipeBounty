(ns rbounty.server.contract.recipe-exchange-mediator
  (:require
   [district.server.smart-contracts :as contracts]))


(defn register-user [user email & [opts]]
  (contracts/contract-call
   :recipe-exchange-mediator :register-user
   user email (merge {:gas 30000000} opts)))


