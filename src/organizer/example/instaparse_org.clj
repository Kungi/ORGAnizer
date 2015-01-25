(ns organizer.example.instaparse-org
  (:require [instaparse.core :as i]))


(def org-grammar
  "org = line+
   <line> = heading
   heading = stars <#' *'> title
   stars = #'\\*+'
   title = #'.*' <EOL>
   <EOL> = '\n' | '\r\n' | #'$'")

(defn org-parse-string [s]
  ((i/parser org-grammar) s))
