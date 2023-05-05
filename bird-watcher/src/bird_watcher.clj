;; Define the namespace for the bird-watcher code
(ns bird-watcher)

;; Define the bird counts for the last week and the current week
(def last-week [0 2 5 3 7 8 4])
(def birds-per-day [2 5 0 7 4 1])

;; Define a function to return the count of birds for today
(defn today [birds]
  (last birds))

;; Define a function to increment the count of birds for the last day
(defn inc-bird [birds]
  (update birds (dec (count birds)) inc))

;; Define a function to check if there was a day with no bird visits in a week
(defn day-without-birds? [birds]
  (boolean (some #(= % 0) birds)))

;; Define a function to calculate the number of bird visits in the first n days
(defn n-days-count [birds n]
  (reduce + (take n birds)))

;; Define a function to count the number of days with 5 or more bird visits
(defn busy-days [birds]
  (let [busy-days (filter #(>= % 5) birds)]
    (count busy-days)))

;; Define a function to check if the bird counts for the week match the odd pattern
(defn odd-week? [birds]
  (let [odd-week-1 [1 0 1 0 1 0 1] odd-week-2 [0 1 0 1 0 1 0]]
    (or (= birds odd-week-1) (= birds odd-week-2))))
