import { describe, it, expect } from 'vitest'
import { stringsOnly } from '../../functions/2-arrays'

describe('stringsOnly (UNION)', () => {
  it('retourne un nouveau tableau', () => {
    const arr = ['hello', null, 'world']
    const actual = stringsOnly(arr)

    expect(Array.isArray(actual)).toBe(true)
    expect(actual).not.toBe(arr)
  })

  it('retourne un tableau sans les éléments "null"', () => {
    const arr = ['hello', null, 'world']
    const actual = stringsOnly(arr)

    expect(actual).toHaveLength(2)
    expect(actual).toEqual(['hello', 'world'])

    const arr2 = [null, null, null, null, null, null, null]
    const actual2 = stringsOnly(arr2)

    expect(actual2).toHaveLength(0)
    expect(actual2).toEqual([])
  })
})
