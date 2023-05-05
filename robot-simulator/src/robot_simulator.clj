(ns robot-simulator)

(defn turn-right [bearing]
  (cond
    (= bearing :north) :east
    (= bearing :south) :west
    (= bearing :east) :south
    (= bearing :west) :north))

(defn turn-left [bearing]
  (cond
    (= bearing :north) :west
    (= bearing :south) :east
    (= bearing :east) :north
    (= bearing :west) :south))

;; TODO: entender como pode o `assoc` estar dentro do `update`
(defn go-forward [robot]
  (cond
    (= (:bearing robot) :north) (update robot :coordinates assoc :y (inc (:y (:coordinates robot))))
    (= (:bearing robot) :south) (update robot :coordinates assoc :y (dec (:y (:coordinates robot))))
    (= (:bearing robot) :east) (update robot :coordinates assoc :x (inc (:x (:coordinates robot))))
    (= (:bearing robot) :west) (update robot :coordinates assoc :x (dec (:x (:coordinates robot))))))

(defn robot [coordinates bearing]
  {:coordinates    coordinates
   :bearing        bearing})

(defn robot-controller [current-robot step]
  (cond
    (= step \R) (assoc current-robot :bearing (turn-right (:bearing current-robot)))
    (= step \L) (assoc current-robot :bearing (turn-left (:bearing current-robot)))
    :else (go-forward current-robot)))

(defn simulate [path robot]
  (let [robot-final (reduce robot-controller robot (seq path))]
    robot-final))
