(ns rich4clojure.easy.problem-032
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Duplicate a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs]
;; 
;; Write a function which duplicates each element of a
;; sequence.

(defn a [seq]
  (reduce (fn [acc b]
            (concat acc (take 2 (repeat b)))) [] seq))
(defn b [seq]
  (reverse (reduce #(conj %1 %2 %2) nil seq)))

(def c #(interleave % %))

(def __ c)

(comment
  (a [1 2 3])
  (b [1 2 3])
  (interleave [1 2 3] [1 2 3])
  (interpose \, [1 2 3])
  (mapcat #(list % %) [1 2 3])
  ((partial mapcat (partial repeat 2)) [1 2 3])
  :rcf)

(tests
 (__ [1 2 3]) := '(1 1 2 2 3 3)
 (__ [:a :a :b :b]) := '(:a :a :a :a :b :b :b :b)
 (__ [[1 2] [3 4]]) := '([1 2] [1 2] [3 4] [3 4])
 (__ [[1 2] [3 4]]) := '([1 2] [1 2] [3 4] [3 4]))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/9e936a6097fdb1fd7a8418a22e3e1170