(ns ^:figwheel-hooks rbounty.dev-ui
  "Browser UI Main Function Entry."
  (:require
   [rbounty.ui.core :refer [init main-config]]
   [district.ui.reagent-render :refer [rerender]]))


(def dev-config
  (merge main-config
         {}))


(defonce start-up
  (do
    "Force it to only reload once"
    (println "Initializing CLJS-UI Development Environment! Type (help) for repl commands.")
    (init dev-config)))


(defn ^:after-load re-mount
  "Figwheel Reload Hook"
  [] (rerender))
