name := "fp-simplified"

version := "0.1"

scalaVersion := "2.12.8"

lazy val fp_simplified = (project in file(".")).aggregate(ch_40_functional_game, ch_44_class_with_for_comp, ch_62_bind, ch_74_io).settings(CommonSettings.commonSettings: _*)

lazy val ch_40_functional_game = project.settings(CommonSettings.commonSettings: _*)

//this project covers 44 to 50 chapters
lazy val ch_44_class_with_for_comp = project.settings(CommonSettings.commonSettings: _*)

// this covers 62 to 71 chapters
lazy val ch_62_bind = project.settings(CommonSettings.commonSettings: _*)


// this contains 74 to 81
lazy val ch_74_io = project.settings(CommonSettings.commonSettings: _*)


// this contains 82 to 99
lazy val ch_82_handling_state = project.settings(CommonSettings.commonSettings: _*)

