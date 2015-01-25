(ns organizer.example.instaparse-org-test
  (:require [organizer.example.instaparse-org :refer :all]
            [clojure.test :refer :all]))


(deftest org-parser-test
  (is (= (org-parse-string "* Hallo\n**    Welt\n***Foo
**** Bar")
         [:org
          [:heading [:stars "*"] [:title "Hallo"]]
          [:heading [:stars "**"] [:title "Welt"]]
          [:heading [:stars "***"] [:title "Foo"]]
          [:heading [:stars "****"] [:title "Bar"]]])))
