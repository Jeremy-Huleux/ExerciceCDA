import { describe, it, expect } from 'vitest'
import { sumStringsAndNumbers } from '../../functions/2-arrays'

describe('sumStringsAndNumbers (UNION)', () => {
  it('retourne un nombre', () => {
    expect(typeof sumStringsAndNumbers(['2', 1, '43', 2])).toBe('number')
  })

  it('retourne la somme de tous les nombres du tableau', () => {
    const arr = ['2', 1, '43', 2]
    expect(sumStringsAndNumbers(arr)).toBe(48)

    const arr2 = ['2', 1, '43', 2, 98, '100']
    expect(sumStringsAndNumbers(arr2)).toBe(246)
  })
})
