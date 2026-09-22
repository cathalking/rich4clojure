(ns rich4clojure.easy.problem-031
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Pack a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs]
;; 
;; Write a function which packs consecutive duplicates
;; into sub-lists.

(def a (fn [s]
         (->> s
              (reduce (fn [[frst & rst] b]
                        (cond (= b (first frst)) (conj rst (conj frst b))
                              (empty? frst) (conj rst (list b))
                              :else (conj rst frst (list b)))) '(()))
              reverse)))
(def __ a)

(comment
  (a [1 1 2 1 1 1 3 3])
  ;;=> (() 1 1 2 1 1 1 3 3)
  (rest '(()))
  (conj () 1 2)
  (cons 2 (cons 1 '()))
  ;;=> (2 1)
  (cons 4 [1 2 3])
  ;;=> (4 1 2 3)
  (conj [1 2 3] 4)
  ;;=> [1 2 3 4]
  (conj '(1 2 3) 4)
  ;;=> (4 1 2 3)
  
  )



(tests
  (__ [1 1 2 1 1 1 3 3]) := '((1 1) (2) (1 1 1) (3 3))
  (__ [:a :a :b :b :c]) := '((:a :a) (:b :b) (:c))
  (__ [[1 2] [1 2] [3 4]]) := '(([1 2] [1 2]) ([3 4])))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/ded02d5ee478eec231bacd671a08b606