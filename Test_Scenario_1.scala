package tests

import Character_Classes.Character

import org.scalatest.funsuite.AnyFunSuite

class Test_Scenario_1 extends AnyFunSuite {

  test("Character build") {

    var Goon: Character = new Character(200, 140, 20, 50, 30, 50, 150, 100, 100, 0, 400, 400, 0, 1, false )
    assert(Goon.max_hp == 200)
    assert(Goon.current_health == 140)
    assert(Goon.attack_power == 20)
    assert(Goon.defense_power == 50)
    assert(Goon.magic_attack == 30)
    assert(Goon.magic_defense == 50)
    assert(Goon.max_magic_points == 150)
    assert(Goon.current_magic_points == 100)
    assert(Goon.character_death_status == false)
  }

  test("Enemy Physical Attack") {

    var Goon: Character = new Character(400, 250, 20, 50, 30, 50, 150, 100, 100, 0, 400, 400, 0, 1, false)
    var Officer: Character = new Character(200, 140, 20, 50, 30, 50, 150, 100, 100, 0, 400, 400, 0, 1, false)
    assert(Goon.current_health == 250)
    Goon.physicalStrike(Officer)
    assert(Goon.current_health == 220)

  }

  test("Enemy Magical Attack") {

    var Goon: Character = new Character(400, 250, 20, 50, 30, 50, 150, 100, 100, 0, 400, 400, 0, 1, false)
    var Officer: Character = new Character(400, 250, 20, 50, 30, 50, 150, 100, 100, 0, 400, 400, 0, 1, false)
    assert(Goon.current_health == 250)
    assert(Officer.current_magic_points == 100)
    Goon.magicalStrike(Officer)
    assert(Officer.current_magic_points == 70)
    assert(Goon.current_health == 230)
  }



}
