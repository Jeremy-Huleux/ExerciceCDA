import { describe, it, expect } from 'vitest'
import { addNumbers } from '../../functions/1-types'

describe('addNumbers', () => {
  it('retourne un nombre', () => {
    expect(typeof addNumbers(1, 2)).toBe('number')
  })

  it('retourne la somme de deux paramètres', () => {
    expect(addNumbers(1, 2)).toBe(3)
    expect(addNumbers(5, 5)).toBe(10)
  })
})
