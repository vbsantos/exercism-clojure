(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[one] deck]
    one))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ two] deck]
    two))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[[one two] tail] (split-at 2 deck)]
    (concat [two one] tail)))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (let [[head & tail] deck]
    [head tail]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[head tail] (split-at 1 deck)]
    (concat head face-cards tail)))
