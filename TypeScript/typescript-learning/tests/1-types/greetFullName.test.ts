import { describe, it, expect } from 'vitest'
import { greetFullName } from '../../functions/1-types'

describe('greetFullName (PARAMETRE OPTIONNEL)', () => {
  it('retourne une chaîne de caractères', () => {
    expect(typeof greetFullName('first', 'last')).toBe('string')
  })

  it('la valeur retournée ne contient pas de "middle name"', () => {
    expect(greetFullName('first', 'last')).toBe('Hello first last')
    expect(greetFullName('Bruce', 'Wayne')).toBe('Hello Bruce Wayne')
  })

  it('la valeur retournée inclue un "middle name"', () => {
    expect(greetFullName('first', 'last', 'middle')).toBe(
      'Hello first middle last'
    )
    expect(greetFullName('Bruce', 'Wayne', 'Thomas')).toBe(
      'Hello Bruce Thomas Wayne'
    )
  })
})
