(ns organizer.example.instaparse-org
  (:require [instaparse.core :as i]
            [clojure.walk :as w]))


(def org-grammar
  "org = block+
   block = heading [content]

   heading = stars <#' *'> title 

   content = (textline | empty-line)+
   textline = #'^[^\\*].+'<EOL>

   empty-line = <EOL>
   stars = #'\\*+'
   title = #'.*' <EOL>
   <EOL> = '\n' | '\r\n' | #'$'")

(defn org-parse-string [s]
  ((i/parser org-grammar) s))

(defn org-analyze-level [ast]
  (w/postwalk (fn [x]
                (if (and (vector? x)
                         (= (x 0) :stars))
                  (.length (x 1))
                  x))
              ast))
