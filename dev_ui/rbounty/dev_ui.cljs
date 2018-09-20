(ns ^:figwheel-hooks rbounty.dev-ui
  (:require
   [rbounty.ui.core :refer [init main-config]]
   [district.ui.reagent-render :refer [rerender]]))


(enable-console-print!)


(def dev-config
  (merge main-config
         {}))


(println "Initializing Development Environment!")
(defonce start-up
  (do
    "Force it to only reload once"
    (init dev-config)))


(defn ^:after-load re-mount
  "Figwheel Reload Hook"
  [] (rerender))
