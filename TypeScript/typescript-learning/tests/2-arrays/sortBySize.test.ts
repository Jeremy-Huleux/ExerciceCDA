import { describe, it, expect } from 'vitest'
import { sortBySize } from '../../functions/2-arrays'

describe('sortBySize', () => {
  it('retourne un tableau de la même taille (ATTENTION, ceci doit être un nouveau tableau)', () => {
    const arr = ['hello', 'world']
    const actual = sortBySize(arr)

    expect(Array.isArray(actual)).toBe(true)
    expect(actual).toHaveLength(arr.length)

    expect(actual).not.toBe(arr)
  })

  it('retourne les string dans l\'ordre attendu', () => {
    const words = [
      'bumbling',
      'semiprecious',
      'discombobulated',
      'aaaaaa',
      'giraffe',
      'numbskull',
    ]
    const expected = [
      'aaaaaa',
      'giraffe',
      'bumbling',
      'numbskull',
      'semiprecious',
      'discombobulated',
    ]

    const actual = sortBySize(words)

    expect(actual).toHaveLength(words.length)
    expect(actual).toEqual(expected)
  })
})
