(ns user
  (:require
   [figwheel.main.api :as fig]))

(println "Welcome to the Recipe Bounty Development Environment!")
(def help-msg "
CLJ Repl Commands:

  (start!)        ;; Build and Watch Server+UI, Connect to UI. [Recommended]

  (watch!)        ;; Build and Watch Server and UI.
  (watch-server!) ;; Build and Watch Server only.
  (watch-ui!)     ;; Build and Watch UI only.

  (cljs-ui)       ;; Connect to UI Browser CLJS Repl.
  (cljs-server)   ;; Connect to Server CLJS Repl.

  (help)          ;; Display this help message.

Notes:

  - You can switch between Server and Browser Repls by exiting the
    previous one with :cljs/exit, and using either `(cljs-ui)`
    or `(cljs-server)`.
")


(println help-msg)
(def help #(println help-msg))


(defn watch-ui! []
  (fig/start {:mode :serve} "dev-ui"))


(defn watch-server! []
  (fig/start {:mode :serve} "dev-server"))


(defn watch! []
  (fig/start {:mode :serve} "dev-server" "dev-ui"))


(defn cljs-ui []
  (fig/cljs-repl "dev-ui"))


(defn cljs-server []
  (fig/cljs-repl "dev-server"))
  

(defn start! []
  (watch!))
