import { describe, it, expect } from 'vitest'
import { sumNumbers } from '../../functions/1-types'

describe('sumNumbers', () => {
  it('retourne un nombre', () => {
    expect(typeof sumNumbers(1, 2)).toBe('number')
    expect(typeof sumNumbers(1, 2, 4)).toBe('number')
  })

  it('retourne la somme des paramètres', () => {
    expect(sumNumbers(1, 2)).toBe(3)
    expect(sumNumbers(5, 5)).toBe(10)
    expect(sumNumbers(5, 5, 5)).toBe(15)
  })
})
