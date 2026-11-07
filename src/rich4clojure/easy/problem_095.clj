(ns rich4clojure.easy.problem-095
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.walk :refer [walk]]))

;; = To Tree, or not to Tree =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [trees]
;; 
;; Write a predicate which checks whether or not a given
;; sequence represents a binary tree. Each node in the
;; tree must have a value, a left child, and a right
;; child.

(def __ b)
(seq? nil)
;;=> false
(seqable? nil)
;;=> true
(seqable? false)
;;=> false
(some? false)

(defn a [[_ y z :as s]]
  (and 
   (= 3 (count s))
   (if (and (some? y) (seqable? y))
     (boolean
      (and (seq y) (a y)))
     true) 
   (if (and (some? z) (seqable? z))
     (boolean
      (and (seq z)
           (a z)))
     true) 
   ))

(defn b [[_ y z :as s]]
  (and 
   (= 3 (count s))
   (seqable? y) 
   (or (nil? y)
       (b y))
   (seqable? z) 
   (or (nil? z)
       (b z))
   ))

(comment
  (b '(:a (:b nil nil) nil))
  ; true
  (b '(:a (:b nil nil)))
  ; false
  (b [1 nil [2 [3 nil nil] [4 nil nil]]])
  ; true
  (b [1 [2 nil nil] [3 nil nil] [4 nil nil]])
  ; false
  (b [1 [2 [3 [4 nil nil] nil] nil] nil])
  ; true
  (b [1 [2 [3 [4 false nil] nil] nil] nil])
  ; true
  (b '(:a (:b nil nil) ()))
  ; false
  (b '(:a nil ()))
  ; false
  (loop [[x y z :as s] '(:a (:b nil nil) nil)
         acc []
         #_'(:a (:b nil nil) '())]
    (do 
      
      (recur y acc)
      )
    )
  (loop [[x y z :as s] '(:a (:b nil nil) nil)
         #_'(:a (:b nil nil) '())]
    (cond
      (not= 3 (count s)) false
      (seq? x) (if (empty? x)
                 false
                 (recur x))
      (seq? y) (if (empty? y)
                 false
                 (recur y))
      (seq? z) (if (empty? z)
                 false
                 (recur z))
      :else true))

  )

(tests
  (__ '(:a (:b nil nil) nil)) :=
   true
  (__ '(:a (:b nil nil))) :=
   false
  (__ [1 nil [2 [3 nil nil] [4 nil nil]]]) :=
   true
  (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]]) :=
   false
  (__ [1 [2 [3 [4 nil nil] nil] nil] nil]) :=
   true
  (__ [1 [2 [3 [4 false nil] nil] nil] nil]) :=
   false
  (__ '(:a nil ())) :=
   false)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/abc33dae1f190ae44f2ebd6d5aeec567