(ns rich4clojure.easy.problem-029
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.string :as string]))

;; = Get the Caps =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [strings]
;; 
;; Write a function which takes a string and returns a new
;; string containing only the capital letters.

(def __1 (fn [s]
          (->> s
               (filter #(let [i (int %)] 
                         (and (>= i (int \A)) 
                              (<= i (int \Z)))))
               (apply str))))
          
(def __2 (fn [s]
          (->> s
               (filter #(Character/isUpperCase %))
               (apply str))))

(def __ (fn [s]
          (->> s
               (re-seq #"[A-Z]")
               (apply str))))
(comment
  (__ "HeLlO, WoRlD!")
  (__ "nothing")
  (__ "$#A(*&987Zf"))
  
(int \A)
;;=> 65
(int \Z)
;;=> 90
(int \a)
;;=> 97
(int \z)
;;=> 122
(tests
  (__ "HeLlO, WoRlD!") := "HLOWRD"
  (__ "nothing") := ""
  (__ "$#A(*&987Zf") := "AZ")

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/bdbcf005bcae10b15531ebe3a7d0be9c