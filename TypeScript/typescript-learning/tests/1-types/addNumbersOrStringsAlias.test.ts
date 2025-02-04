import { describe, it, expect } from 'vitest'
import { addNumbersOrStringsAlias } from '../../functions/1-types'

describe('addNumbersOrStrings', () => {
  it('retourne un nombre', () => {
    expect(typeof addNumbersOrStringsAlias(1, 2)).toBe('number')
    expect(typeof addNumbersOrStringsAlias('1', '2')).toBe('number')
    expect(typeof addNumbersOrStringsAlias('1', 2)).toBe('number')
    expect(typeof addNumbersOrStringsAlias(1, '2')).toBe('number')
  });

  it('retourne la somme de deux paramètres', () => {
    expect(addNumbersOrStringsAlias(1, 2)).toBe(3)
    expect(addNumbersOrStringsAlias(5, 5)).toBe(10)
    expect(addNumbersOrStringsAlias('1', 2)).toBe(3)
    expect(addNumbersOrStringsAlias('5', 5)).toBe(10)
    expect(addNumbersOrStringsAlias(1, '2')).toBe(3)
    expect(addNumbersOrStringsAlias(142, 356)).toBe(498)
  })
})
