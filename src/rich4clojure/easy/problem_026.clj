(ns rich4clojure.easy.problem-026
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Fibonacci Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [Fibonacci seqs]
;; 
;; Write a function which returns the first X fibonacci
;; numbers.

(def __1 (fn [x]
          (loop [i 1
                 acc '()]
            (if (> (+ i 1) x)
              acc
              (recur (inc i) (cons (+ (last acc) i) acc))))))

(def __2 (fn [x]
          (loop [i 0
                 j 1]
            (if (>= i x)
              j
              (recur i (+ i j))))))

(def __ (fn[x]
          (loop [acc '(1)]
            (if (= x (count acc))
              (reverse acc)
              (recur (cons (apply + (take 2 acc)) acc))))))
(__ 2)
(let [acc '(2 1 1 0)]
  (cons (apply + (take 2 acc)) acc))

(comment
 cons)  
  

(tests
  (__ 3) := '(1 1 2)
  (__ 6) := '(1 1 2 3 5 8)
  (__ 8) := '(1 1 2 3 5 8 13 21))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/87153a8e55b56058703e5bca6f8ba62a