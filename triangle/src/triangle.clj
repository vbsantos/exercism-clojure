(ns triangle)

;; All sides have to be of length > 0
;; The sum of the lengths of two sides must be greater than the third side
(defn is-valid?
  [side1 side2 side3]
  (let [side-size-validation (and (> side1 0) (> side2 0) (> side3 0))
        side-sum-validation (not (or (> side1 (+ side2 side3)) (> side2 (+ side1 side3)) (> side3 (+ side1 side2))))]
    (and side-size-validation side-sum-validation)))

;; An equilateral triangle has all three sides the same length.
(defn equilateral?
  [side1 side2 side3]
  (let [is-valid (is-valid? side1 side2 side3)
        is-equilateral (= side1 side2 side3)]
    (and is-valid is-equilateral)))

;; A scalene triangle has all sides of different lengths.
(defn scalene?
  [side1 side2 side3]
  (let [is-valid (is-valid? side1 side2 side3)
        is-scalene (not (or (= side1 side2) (= side1 side3) (= side2 side3)))]
    (and is-valid is-scalene)))

;; An isosceles triangle has at least two sides the same length
(defn isosceles?
  [side1 side2 side3]
  (let [is-valid (is-valid? side1 side2 side3)
        is-isosceles (or (= side1 side2) (= side1 side3) (= side2 side3))]
    (and is-valid is-isosceles)))
