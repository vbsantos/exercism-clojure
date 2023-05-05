(ns sublist)

(defn is-sublist? [list1 list2]
  (some #(= list1 %) (partition (count list1) 1 list2)))

(defn is-equal? [list1 list2]
  (= list1 list2))

(defn classify [list1 list2]
  (cond
    (is-equal? list1 list2) :equal
    (is-sublist? list1 list2) :sublist
    (is-sublist? list2 list1) :superlist
    :else :unequal))
