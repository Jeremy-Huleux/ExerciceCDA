import { describe, it, expect } from 'vitest'
import { generateUsername } from '../../functions/2-arrays'

describe('generateUsername (TUPLE)', () => {
  it('retourne une chaîne de caractères', () => {
    expect(typeof generateUsername(['John', 'Smith', 1990])).toBe('string')
  })

  it('retourne le nom de l\'utilisateur dans un format correct', () => {
    const details: [string, string, number] = ['Ada', 'Lovelace', 1815]
    expect(generateUsername(details)).toBe('lovelacead_1815')
  })
})
