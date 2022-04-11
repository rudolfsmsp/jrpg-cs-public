package Character_Classes

class Character (var max_hp: Int,
                 var current_health: Int,
                 var attack_power: Int,
                 var defense_power: Int,
                 var magic_attack: Int,
                 var magic_defense: Int,
                 var max_magic_points: Int,
                 var current_magic_points: Int,
                 var experience_required_to_level_up: Int = 100,
                 var starting_experience: Int,
                 var gained_experience: Int,
                 var earned_experience: Int ,
                 var party_experience: Int,
                 var character_level: Int,
                 var character_death_status: Boolean) {


  def takeDamage(enemy_attack_power: Int): Unit = {

    current_health -= enemy_attack_power

    if (current_health == 0) {

      character_death_status = true

    }

  }

  def physicalStrike(enemy_character: Character): Unit = {

    var friendly_defense_damage: Int = defense_power - enemy_character.attack_power // How much damage has already been done taking account my defense

    takeDamage(friendly_defense_damage)


  }

  def magicalStrike(enemy_character: Character): Unit = {

    var friendly_magic_defense_damage: Int = magic_defense - enemy_character.magic_attack

    if (enemy_character.current_magic_points >= 30) { // Taking away from current magic points the enemy magic damage count

      enemy_character.current_magic_points -= 30

      takeDamage(friendly_magic_defense_damage)

    }

  }

  def level_up(): Unit = {

    if (character_death_status == false) {

      while (experience_required_to_level_up < earned_experience) {

        earned_experience = earned_experience - experience_required_to_level_up

        character_level = character_level + 1

        experience_required_to_level_up = experience_required_to_level_up * 2

        attack_power = attack_power * 2

        defense_power = defense_power * 2

        magic_defense = magic_defense * 2

        magic_attack = magic_attack * 2

        max_hp = max_hp * 2

      }

    }

  }

  def gainedExperience(added_exp: Int): Unit = {

    if (character_death_status == true) {

      earned_experience = 0

    }


    else if (character_death_status == false) {

      earned_experience = earned_experience + added_exp

      if (earned_experience > experience_required_to_level_up) {

        level_up()

      }

    }

  }

}
