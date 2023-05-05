(ns bank-account)

;; ;; defrecord -
;; (defrecord Account [balance])

;; ;; The constructor function is simply named ->Account due to the naming convention used when defining records with defrecord
;; ;; ref is a mutable reference to a value
;; (defn open-account []
;;   (->Account (ref 0)))

;; Use a map with a single key :balance
(defn open-account []
  {:balance (ref 0)})

;; dosync macro is used to create a transaction in which you can update one or more refs atomically
;; ref-set function directly sets a ref's value within a transaction
(defn close-account [account]
  (dosync
   (ref-set (:balance account) nil))
  account)

;; deref or @: To access the current value of a ref
(defn get-balance [account]
  (deref (:balance account)))

;; alter function updates a ref's value by applying a function to its current value, within a transaction
(defn update-balance [account amount]
  (dosync (alter (:balance account) + amount)))
(ns bank-account)
