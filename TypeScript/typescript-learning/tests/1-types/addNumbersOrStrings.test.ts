import { describe, it, expect } from 'vitest'
import { addNumbersOrStrings } from '../../functions/1-types'

describe('addNumbersOrStrings', () => {
  it('retourne un nombre', () => {
    expect(typeof addNumbersOrStrings(1, 2)).toBe('number')
    expect(typeof addNumbersOrStrings('1', '2')).toBe('number')
    expect(typeof addNumbersOrStrings('1', 2)).toBe('number')
    expect(typeof addNumbersOrStrings(1, '2')).toBe('number')
  });

  it('retourne la somme de deux paramètres', () => {
    expect(addNumbersOrStrings(1, 2)).toBe(3)
    expect(addNumbersOrStrings(5, 5)).toBe(10)
    expect(addNumbersOrStrings('1', 2)).toBe(3)
    expect(addNumbersOrStrings('5', 5)).toBe(10)
    expect(addNumbersOrStrings(1, '2')).toBe(3)
    expect(addNumbersOrStrings(142, 356)).toBe(498)
  })
})
