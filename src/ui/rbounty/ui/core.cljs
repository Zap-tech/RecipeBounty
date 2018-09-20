(ns rbounty.ui.core
  (:require
   [re-frame.core :as re-frame]
   [reagent.core :as reagent]
   [mount.core :as mount]

   ;; Reagent Component
   [rbounty.ui.components.app-layout :refer [c-app-layout]]

   ;; Mount States
   [district.ui.reagent-render]))


;; set by figwheel build
(goog-define DEV false)


(def main-config
  {:reagent-render {:id "app"
                    :component-var #'c-app-layout}})


(defn ^:export init [config]
  (println "Initializing UI...")
  (mount/start (mount/with-args config)))


;; Automatically initialize when in production build
(when-not DEV (init main-config))
