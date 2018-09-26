(ns rbounty.server.utils)


(defmacro on-next-tick
  "Wraps `body` in a function, and runs the function in a node event
  loop on the next tick.

  Example:

  (on-next-tick
   (super-slow-synchronous-task)
   (println \"Finished!\"))

  ;; ...
  ;; Finished!"
  [& body]
  `(.nextTick js/process (fn [] ~@body)))

