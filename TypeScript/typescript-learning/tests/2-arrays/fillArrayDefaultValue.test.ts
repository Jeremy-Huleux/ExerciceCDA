import { describe, it, expect } from 'vitest'
import { fillArrayWithDefaultValue } from '../../functions/2-arrays'

describe('fillArrayWithDefaultValue', () => {
  it('renvoie un tableau de taille correcte', () => {
    const actual = fillArrayWithDefaultValue(1, "test")
    expect(Array.isArray(actual)).toBe(true)
    expect(actual).toHaveLength(1)

    expect(fillArrayWithDefaultValue(5, "test")).toHaveLength(5)
    expect(fillArrayWithDefaultValue(10, "test")).toHaveLength(10)
  })

  it('retourne un tableau de chaînes de caractères', () => {
    const arr = fillArrayWithDefaultValue(2, "string")
    expect(typeof arr[0]).toBe('string')
    expect(typeof arr[1]).toBe('string')
  })

  it('retourne un tableau de chaînes "test"', () => {
    const arr = fillArrayWithDefaultValue(3, "test")
    expect(arr).toEqual(['test', 'test', 'test'])
  })
})
