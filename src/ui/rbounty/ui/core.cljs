(ns rbounty.ui.core
  (:require
   [re-frame.core :as re-frame]
   [reagent.core :as reagent]
   [mount.core :as mount]
   [taoensso.timbre :as log]

   ;; Reagent Component
   [rbounty.ui.components.app-layout :refer [c-app-layout]]

   ;; Mount States
   [district.ui.logging]
   [district.ui.reagent-render]))


;; set by figwheel build
(goog-define DEV false)


(def main-config
  {:reagent-render {:id "app"
                    :component-var #'c-app-layout}})


(defn ^:export init [config]
  (log/info "Initializing UI...")
  (mount/start (mount/with-args config)))


;; Automatically initialize when in production build
(when-not DEV (init main-config))
