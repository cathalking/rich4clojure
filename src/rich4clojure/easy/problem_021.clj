(ns rich4clojure.easy.problem-021
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Nth Element =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;; 
;; Write a function which returns the Nth element from a
;; sequence.

(def restricted [nth])

(def __1 (fn [s n] 
          (loop [s s
                 n n]
            (if (zero? n)
              (first s)
              (recur (rest s) (dec n))))))
(def __2 
  #(loop [s %1
          n %2]
     (if (zero? n)
       (first s)
       (recur (rest s) (dec n)))))

(def __3 #(first (drop %2 %1)))

(def __ (fn [s n] 
           (if (zero? n)
             (first s)
             (recur (rest s) (dec n)))))

  (comment
    )

(tests
  (__ '(4 5 6 7) 2) := 6
  (__ [:a :b :c] 0) := :a
  (__ [1 2 3 4] 1) := 2
  (__ '([1 2] [3 4] [5 6]) 2) := [5 6])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/327178a78d8d0b021a72c75b0876a225