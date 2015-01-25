(ns organizer.example.instaparse-org-test
  (:require [organizer.example.instaparse-org :refer :all]
            [clojure.test :refer :all]))


(def org-test-string
  "* Hallo\n**    Welt\n***Foo
**** Bar")

(deftest org-heading-parser-test
  (is (= (org-parse-string org-test-string)
         [:org
          [:block [:heading [:stars "*"] [:title "Hallo"]]]
          [:block [:heading [:stars "**"] [:title "Welt"]]]
          [:block [:heading [:stars "***"] [:title "Foo"]]]
          [:block [:heading [:stars "****"] [:title "Bar"]]]])))

(deftest org-level-test
  (is (= (org-analyze-level (org-parse-string org-test-string))
         [:org
          [:block [:heading 1 [:title "Hallo"]]]
          [:block [:heading 2 [:title "Welt"]]]
          [:block [:heading 3 [:title "Foo"]]]
          [:block [:heading 4 [:title "Bar"]]]])))

(deftest org-parser-can-parse-text-blocks
  (is (= (org-parse-string
          "* Foo
   Hallo
   - Welt
   - 23")
         [:org
          [:block
           [:heading [:stars "*"] [:title "Foo"]]
           [:content
            [:textline "   Hallo"]
            [:textline "   - Welt"]
            [:textline "   - 23"]]]]))) 
