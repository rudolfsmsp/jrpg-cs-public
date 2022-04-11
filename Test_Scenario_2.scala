package tests

import Character_Classes.Character

import org.scalatest.funsuite.AnyFunSuite


class Test_Scenario_2 extends AnyFunSuite{

    test("Level Up / Gain Exp / Multiple Exp") {

      var Criminal: Character = new Character(200, 140, 20, 50, 30, 50, 150, 100, 100, 200, 300, 500, 0, 5, false )

      assert(Criminal.starting_experience == 200)
      assert(Criminal.gained_experience == 300)
      assert(Criminal.earned_experience == 500)
      assert(Criminal.character_level == 5)
      assert(Criminal.experience_required_to_level_up == 100)
      assert(Criminal.character_death_status == false)

      var Policeman: Character = new Character(200, 140, 20, 50, 30, 50, 150, 100, 100, 100, 200, 300, 0, 3, true )

      assert(Policeman.starting_experience == 100)
      assert(Policeman.gained_experience == 200)
      assert(Policeman.earned_experience == 300)
      assert(Policeman.character_level == 3)
      assert(Policeman.experience_required_to_level_up == 100)
      assert(Policeman.character_death_status == true)


      Criminal.gainedExperience(300)
      assert(Criminal.earned_experience == 100)
      assert(Criminal.character_level == 8)

    }

}
