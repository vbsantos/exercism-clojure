(ns interest-is-interesting)

(defn interest-rate
  "The interest rate your bank gives
   you depends on the amount of money
   in your account"
  [balance]
  (cond
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (< balance 5000) 1.621
    :else 2.475))

(defn annual-balance-update
  "calculate the annual balance update"
  [balance]
  (let [interest-rate-as-decimal (bigdec (/ (Math/abs (interest-rate balance)) 100.0))]
    (.setScale (-> balance
                   (.multiply interest-rate-as-decimal)
                   (.add balance))
               17 java.math.RoundingMode/HALF_EVEN)))

(defn amount-to-donate
  "calculate how much money to donate
   to charities based on the balance
   and the tax-free percentage that
   the government allows"
  [balance tax-free-percentage]
  (let [tax-free-dollars (* (/ tax-free-percentage 100) balance)
        total-donated (* 2 tax-free-dollars)]
    (max 0 (int (Math/floor total-donated)))))
