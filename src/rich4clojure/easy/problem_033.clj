(ns rich4clojure.easy.problem-033
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Replicate a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs]
;; 
;; Write a function which replicates each element of a
;; sequence a variable number of times.

(def __ d)

(defn a [seq n]
  (mapcat #(repeat n %) seq))

(defn b [seq n]
  (->> seq
       (map #(repeat n %))
            (apply concat)))

(defn c [seq n]
  (->> seq
       (reduce (fn [acc a] (apply (partial conj acc) (repeat n a))) '())
       reverse))

(defn d [seq n]
  (apply interleave (repeat n seq)))

(comment
  
  (mapcat #(repeat 2 %) [1 2 3])
  (->> [1 2 3]
       (map #(repeat 2 %))
       (apply concat))
  (->> [1 2 3]
       (reduce (fn [acc a] (apply (partial conj acc) (repeat 2 a))) '())
       reverse
       )
  (apply interleave (repeat 2 [1 2 3]))
  :rcf)
  
  

(tests
  (__ [1 2 3] 2) := '(1 1 2 2 3 3)
  (__ [:a :b] 4) := '(:a :a :a :a :b :b :b :b)
  (__ [4 5 6] 1) := '(4 5 6)
  (__ [[1 2] [3 4]] 2) := '([1 2] [1 2] [3 4] [3 4])
  (__ [44 33] 2) := [44 44 33 33])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/3e4dc6bf1479a57ffcd2ef05bdc5bb52