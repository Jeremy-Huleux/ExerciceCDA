import { describe, it, expect } from 'vitest'
import { getNextMapCoord, Direction } from '../../functions/2-arrays'

describe('getNextMapCoord (TUPLE et ALIAS)', () => {
  it('retourne un tuple de taille correcte', () => {
    const actual = getNextMapCoord([1, 2], Direction.North)
    expect(Array.isArray(actual)).toBe(true)
    expect(actual).toHaveLength(2)
  })

  it('retourne un tuple avec les valeurs attendues', () => {
    expect(getNextMapCoord([42, 12], Direction.North)).toEqual([42, 13])
    expect(getNextMapCoord([1, 2], Direction.East)).toEqual([2, 2])
    expect(getNextMapCoord([13, 26], Direction.West)).toEqual([12, 26])
    expect(getNextMapCoord([10, 20], Direction.South)).toEqual([10, 19])
  })
})
